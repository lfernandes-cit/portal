angular.module('portal').controller('EcController' , function ($scope, $http) {
	
	$scope.teste = 'testefhjd';
	
	$http.get('http://localhost:8080/portal/ec?idUsuario=2').then(function (response) {
		console.log(response.data.object);
		$scope.ecs = response.data.object;
		
	});
	
		
	
	
});