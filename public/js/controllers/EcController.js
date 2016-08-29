angular.module('portal').controller('EcController' , function ($scope, $http, $cookies, $location, IpFactory, $rootScope, $timeout) {

	if ($rootScope.messages) {
		$scope.mostraMensagem = true;
		//$timeout(function() {$scope.mostraMensagem = false;}, 5000); 
		$scope.messages = $rootScope.messages;	
		
	}
	
	var idUsuario = $cookies.getObject("usuarioLogado").id;


	listaEc = function(){
		$http.get(IpFactory.host + '/portal/ec/usuario/?idUsuario='+idUsuario).then(function (response) {
			$scope.ecs = response.data.object;

		});
	}

	$scope.apagarMensagem = function () {
		$scope.mostraMensagem = !$scope.mostraMensagem;
	}

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

	$scope.editarEc = function (ec) {
		$location.path( "/ec/editar/" + ec.id);
	}

	$scope.excluir = function(id){
		$http.delete(IpFactory.host + '/portal/ec?id='+id).then(
		function(retorno){
			listaEc();
		},
		function(erro){
				console.log("Erro"+ erro);
		});

	}

	$scope.excluirTodos = function(){
		if ($scope.ecs && $scope.ecs.length > 0) {
			$scope.ecs.map(function(ec){
				if (ec.selecionado) {
					$scope.excluir(ec.id);
				}
			});
			listaEc();
		}
	}

	listaEc();

});
