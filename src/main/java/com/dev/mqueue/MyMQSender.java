package com.dev.mqueue;

import javax.jms.JMSException;
import javax.jms.Session;

import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class MyMQSender {
 /**
  * Main method
  * 
  * @param args
  */
 public static void main(String[] args) {
  try {
			for (int i = 1; i <= 1; i++) {
				sendMsg(i);
	  }
  } catch (JMSException jmsex) {
   System.out.println(jmsex);
   System.out.println("\\nFAILURE\\n");
  } catch (Exception ex) {
   System.out.println(ex);
   System.out.println("\\nFAILURE\\n");
  }
 }

private static void sendMsg(int i) throws JMSException {
	MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
	
	   // Config
	  
	   
	   
	   cf.setHostName("xyz_host");
	   cf.setPort(1414);
	   cf.setQueueManager("ENT01D");
	   cf.setChannel("ENT01D.SVRCONN");
	   
	 
	
	   
	   cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
	   MQQueueConnection connection = (MQQueueConnection) cf
	     .createQueueConnection();
	   MQQueueSession session = (MQQueueSession) connection
	     .createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	   MQQueue queue = (MQQueue) session
			   //QC.FRN.LOGISTICS.DOCREADY.INPUT
	     .createQueue("queue:///QC.FRN.LOGISTICS.OBASN.INPUT");
	   MQQueueSender sender = (MQQueueSender) session.createSender(queue);
	   // MQQueueReceiver receiver = (MQQueueReceiver)
	   // session.createReceiver(queue);
	
	   // long uniqueNumber = System.currentTimeMillis() % 1000;
			   + "<esb:VersionNbr>1.0</esb:VersionNbr>"
			   + "<esb:BusinessEvent>"
	   + "<esb:TransactionTypeCode>DC_DR_OBASN</esb:TransactionTypeCode> " 
	   +  "<esb:Timestamp>2014-01-22T12:40:08.636-08:00</esb:Timestamp>"
	   + "<esb:EventID>OBASN_00000000000000000491</esb:EventID>"
	   + "<esb:TotalRecordCount>1</esb:TotalRecordCount>"
	   + "</esb:BusinessEvent>"
	   + "<esb:SourceSystem>"
	   + "<esb:DCID>27</esb:DCID>"
	   + "<esb:ApplicationName>RGTI</esb:ApplicationName>"
	   + "</esb:SourceSystem>"
	   + "<esb:RoutingInformation>"
	   + "<esb:Type>"
	   + "<esb:RoutingTypeName>TRANSACTION</esb:RoutingTypeName>"
	   + "<esb:Label>"
	   + "<esb:LabelName>TRANSACTION_TYPE_CODE</esb:LabelName>"
	   + "<esb:LabelValueText>DC_DR_OBASN</esb:LabelValueText>"
	   + "</esb:Label>"
	   + "</esb:Type>"
	   + "</esb:RoutingInformation>"
	   + "<esb:DatasetInfo>"
	   + "<esb:TotalDatasetCount>1</esb:TotalDatasetCount>"
	   + "<esb:DatasetNbr>1</esb:DatasetNbr>"
	   + "<esb:DatasetSizeQty>1</esb:DatasetSizeQty>"
	   + "<esb:KeyField1>RUG0000162</esb:KeyField1>"
	   + "</esb:DatasetInfo>"
	   + "</esb:ESBHeader>"
	   + "<dc:EBOPayload>"
	   + "<dc:OutboundASN>"
	   + "<dc:TransactionType>DR</dc:TransactionType>"
	   + "<dc:Corp>0001</dc:Corp>"
	   + "<dc:MasterBOL>RUG0000162</dc:MasterBOL>"
	   + "<dc:OriginatingDC>00027</dc:OriginatingDC>"
	   + "<dc:ShipDate/>"
	   + "<dc:PoolerLocationID/>"
	   + "<dc:PoolerLabelID/>"
	   + "<dc:SCAC/>"
	   + "<dc:MemoBOL/>"
	   + "<dc:TargetDate/>"
	   + "<dc:TargetTime/>"
	   + "<dc:Store>04321</dc:Store>"
	   + "<dc:InStoreDate>20140122</dc:InStoreDate>"
	   + "<dc:CartonID>00004200270396624146</dc:CartonID>"
	   + "<dc:CartonContents>CB</dc:CartonContents>"
	   + "<dc:Weight>00068</dc:Weight>"
	   + "<dc:Volume>00010</dc:Volume>"
	   + "<dc:ItemID>301471936</dc:ItemID>"
	   + "<dc:PrepackFlag>0</dc:PrepackFlag>"
	   + "<dc:Units>0000200</dc:Units>"
	   + "<dc:ReferenceNumber>6000001525</dc:ReferenceNumber>"
	   + "<dc:MerchandiseIndicator>MERCHANDISE</dc:MerchandiseIndicator>"
	   + "<dc:PalletName/>"
	   + "<dc:TMLoadID/>"
	   + "<dc:VendorLocationCode/>"
	   + "<dc:PO/>"
	   + "<dc:MasterBOLTotalLines>2</dc:MasterBOLTotalLines>"
	   + "<dc:MasterBOLLineNumber>"+i+"</dc:MasterBOLLineNumber>" 
	   + "</dc:OutboundASN>"
	   + "</dc:EBOPayload>"
	   + "</dc:EBO>";  
	   JMSTextMessage message = (JMSTextMessage) session
	     .createTextMessage(inputXML);
	   message.setJMSCorrelationID("1145611");
	   // Start the connection
	   connection.start();
	   sender.send(message);
	   System.out.println("Sent message:\\n" + message);
	
	   // JMSMessage receivedMessage = (JMSMessage)
	   // receiver.receive(10000);
	   // System.out.println("\\nReceived message:\\n" + receivedMessage);
	
	   sender.close();
	   // receiver.close();
	   session.close();
	   connection.close();
	
	   System.out.println(i +"  \\nSUCCESS\\n ");
}
}
