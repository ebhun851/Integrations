package com.dev.mqueue;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class QueueManager_OBASN {

    private final String host;
    private final int port;
    private final String channel;
    private final String manager;
    private final MQQueueManager qmgr;

    public QueueManager_OBASN(String host, int port, String channel, String manager) throws MQException {
        this.host = host;
        this.port = port;
        this.channel = channel;
        this.manager = manager;
        this.qmgr = createQueueManager();
    }

    public int depthOf(String queueName) throws MQException {
        MQQueue queue = qmgr.accessQueue(queueName, MQC.MQOO_INQUIRE | MQC.MQOO_INPUT_AS_Q_DEF, null, null, null);
        return queue.getCurrentDepth();
    }

    private MQQueueManager createQueueManager() throws MQException {
        MQEnvironment.channel = channel;
        MQEnvironment.port = port;
        MQEnvironment.hostname = host;
        MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES);
        return new MQQueueManager(manager);
    }
    
	public static void main(String[] args) throws MQException {
		QueueManager_OBASN manager = new QueueManager_OBASN("xxx_host", 1414, "xyz_channel", "ENT01D");
		System.out.println("Current queue depth: "+manager.depthOf("QC.FRN.LOGISTICS.OBASN.INPUT"));
//		QC.FRN.LOGISTICS.OBASN.INPUT
	}




}
