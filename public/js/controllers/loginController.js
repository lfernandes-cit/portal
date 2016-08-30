angular.module('portal').controller("LoginController", function($scope, $rootScope, $http, $location, $cookies, IpFactory){

    $scope.message = "";

    $scope.logar = function(usuario){
        console.log(usuario);

        $http.post(IpFactory.host + "/portal-api/usuario", usuario).then(
        function(retorno){
            if(retorno.data && retorno.data.object){
                $cookies.putObject("usuarioLogado", retorno.data.object);
                $rootScope.usuarioLogado = $cookies.getObject("usuarioLogado");
                $location.path( "/ec");
            }else{
              $scope.message = "Usuario ou senha inválido.";
            }
        },
        function(erro){
            console.log("Erro"+ erro);
        });
    }

});
