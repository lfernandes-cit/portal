angular.module('portal').controller("LoginController", function($scope, $http, $location, $cookies){

    $scope.logar = function(usuario){
        console.log(usuario);

        $http.post("http://172.16.18.120:8080/portal/usuario", usuario).then(
        function(retorno){
            if(retorno.data && retorno.data.object.id){
                $cookies.putObject("usuarioLogado", retorno.data.object);
                $location.path( "/ec");
            }
        },
        function(erro){
            console.log("Erro"+ erro); 
        }); 
    }

});
