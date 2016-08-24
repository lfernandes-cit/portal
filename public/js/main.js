angular.module('portal', ['ngRoute', 'ngResource'])
    .config(function($routeProvider, $locationProvider){

        $locationProvider.html5Mode(true);

        $routeProvider.when('/login', {
            templateUrl: 'partials/login.html',
            controller: 'LoginController'
        });

        $routeProvider.otherwise({redirectTo: '/'});

    });
