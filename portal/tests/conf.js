
exports.config = {
    baseUrl: 'http://localhost:3000',

    seleniumAddress: 'http://localhost:4444/wd/hub',

    framework: 'custom',

    frameworkPath: '../node_modules/protractor-cucumber-framework',

    specs: [
        'e2e/features/**/*.feature'
    ],

    jasmineNodeOpts: {
        showColors: true
    },

    cucumberOpts: {
        require: 'e2e/**/*.js',
        format: 'pretty' // or summary
    }
};