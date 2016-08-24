angular.module('portal', ['ngRoute', 'ngResource'])
    .config(function($routeProvider, $locationProvider){

        $locationProvider.html5Mode(true);

        $routeProvider.when('/', {
            templateUrl: 'index.html'
        });

        $routeProvider.otherwise({redirectTo: '/'});

    });
