angular.module('portal').controller("FormEcController", function($scope, $http, IpFactory, $cookies, $location){

	
    
    $http.get(IpFactory.host + '/portal/pais').then(function (response) {
		$scope.paises = response.data.object;
		
	});
    
    $scope.salvarEc = function(ec) {
    	
    	ec.usuario = $cookies.getObject("usuarioLogado");
    	$http.post(IpFactory.host + "/portal/ec", ec).then(
    	        function(retorno){
    	            if(retorno){
    	                $location.path( "/ec");
    	            }
    	        },
    	        function(erro){
    	            console.log("Erro"+ erro); 
    	        }); 
    }

});
