angular.module('portal', ['ngRoute', 'ngResource', 'ngCookies', 'ui.mask'])
.config(function($routeProvider, $locationProvider, $httpProvider){

	$locationProvider.html5Mode(true);

	$routeProvider.when('/login', {
		templateUrl: 'partials/login.html',
		controller: 'LoginController'
	});

	$routeProvider.when('/ec',{
		templateUrl: 'partials/ec.html',
		controller: 'EcController'
	});
	
	$routeProvider.when('/ec/adicionar',{
		templateUrl: 'partials/ecForm.html',
		controller: 'FormEcController'
	});

	$routeProvider.when('/ec/editar/:id',{
		templateUrl: 'partials/ecForm.html',
		controller: 'FormEcController'
	});

	$httpProvider.defaults.headers.common['Authorization'] = 'Basic cG9ydGFsOnAwcnRAbA==';
	$httpProvider.defaults.headers.common['Accept'] = 'application/json, text/javascript';


	$routeProvider.otherwise({redirectTo: '/'});

});
