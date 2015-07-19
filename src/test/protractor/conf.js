var HtmlReporter = require('protractor-html-screenshot-reporter');
var phantomjs = require('phantomjs')

exports.config = {
	seleniumAddress : 'http://localhost:4444/wd/hub',
	specs : [ 'specs/*.js' ],
	// For single browser configuration
	/*
	 * capabilities :{ 'browserName': 'chrome', },
	 */

	// For multi browser configuration
	/*
	 * multiCapabilities :[{ 'browserName': 'chrome', },{ 'browserName':
	 * 'firefox', }],
	 */

	// For headless configuration
	capabilities : {
		'browserName' : 'phantomjs',

		/*
		 * Can be used to specify the phantomjs binary path. This can generally
		 * be ommitted if you installed phantomjs globally.
		 */
		'phantomjs.binary.path' : phantomjs.path,

		/*
		 * Command line args to pass to ghostdriver, phantomjs's browser driver.
		 * See https://github.com/detro/ghostdriver#faq
		 */
		'phantomjs.ghostdriver.cli.args' : [ '--loglevel=DEBUG' ]
	},
	onPrepare : function() {
		// Add a screenshot reporter and store screenshots to `/tmp/screnshots`:
		jasmine.getEnv().addReporter(new HtmlReporter({
			baseDirectory : './results/screenshots'
		}));
	}
}