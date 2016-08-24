angular.module('portal', ['ngRoute', 'ngResource'])
    .config(function($routeProvider, $httpProvider){

        $routeProvider.when('/', {
           templateUrl: 'index.html'
        });

        $routeProvider.otherwise({redirectTo: '/'});

    });
