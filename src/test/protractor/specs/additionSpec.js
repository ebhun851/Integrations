describe('Arithematic calculations', function() {
	firstElement = element(by.model('first'));
	secondElement = element(by.model('second'));
	button = element(by.id('gobutton'));
	latestValueElement = element(by.binding('latest'));

	beforeEach(function(){
		browser.get('http://localhost:8080/GRest/');
	});

  it('should add one and two', function() {
    firstElement.sendKeys(1);
    secondElement.sendKeys(2);
    button.click();
    expect(latestValueElement.getText()).toEqual('3'); 
  });

  it("should add four and five",function(){
  	firstElement.sendKeys(4);
    secondElement.sendKeys(5);
    button.click();
    expect(latestValueElement.getText()).toEqual('9'); 
  });
});