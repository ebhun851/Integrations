var HtmlReporter = require('protractor-html-screenshot-reporter');
// var phantomjs = require('phantomjs')

exports.config = {
	seleniumAddress : 'http://localhost:4444/wd/hub',
	specs : [ 'specs/*.js' ],
	// For single browser configuration
	/*
	 * capabilities :{ 'browserName': 'chrome', },
	 */

	// For multi browser configuration
	multiCapabilities : [ {
		browserName : 'firefox'
	}, {
		browserName : 'chrome'
	} ],

	onPrepare : function() {
		jasmine.getEnv().addReporter(new HtmlReporter({
			baseDirectory : './results/screenshots'
		}));
	}
}