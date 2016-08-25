angular.module('portal').controller('EcController' , function ($scope, $http, $cookies, $location) {
	
	var idUsuario = $cookies.getObject("usuarioLogado").id;
	
	$http.get('http://172.16.18.120:8080/portal/ec?idUsuario='+idUsuario).then(function (response) {
		$scope.ecs = response.data.object;
		
	});
	
	$scope.selecionarTodos = function () {

		if ($scope.checkSelecionarTodos) {
			$scope.checkSelecionarTodos = true;
		} else {
			$scope.checkSelecionarTodos = false;
		}
		
		angular.forEach($scope.ecs, function (ec){
			ec.selecionado = $scope.checkSelecionarTodos;
		}); 
	}
	
	$scope.ordenarPor = function (campo) {
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
		$scope.criterioDeOrdenacao = campo;
	}
	
	$scope.adicionarEc = function () {
		$location.path( "/ec/adicionar");
	}
	
});
