describe('Protractor Demo App', function() {
  it('should have a title', function() {
    browser.get('http://localhost:8080/Integrations/');

    expect(browser.getTitle()).toEqual('Super Calculator');
  });
});