angular.module('portal').controller('EcController' , function ($scope, $http, $cookies) {
	
    $scope.teste = 'testefhjd';

	$http.get('http://172.16.18.120:8080/portal/ec?idUsuario=2').then(function (response) {
		console.log(response.data.object);
		$scope.ecs = response.data.object;
		
	});
	
		
	
	
});
