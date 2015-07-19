describe('Protractor Demo App', function() {
  it('should have a title', function() {
    browser.get('http://localhost:8080/GRest/');

    expect(browser.getTitle()).toEqual('Super Calculator');
  });
});