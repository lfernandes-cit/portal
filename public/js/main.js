angular.module('portal', ['ngRoute', 'ngResource', 'ngCookies'])
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
        
        $httpProvider.defaults.headers.common['Authorization'] = 'Basic cG9ydGFsOnAwcnRAbA==';
        $httpProvider.defaults.headers.common['Accept'] = 'application/json, text/javascript';
        
        
        $routeProvider.otherwise({redirectTo: '/'});

    });
