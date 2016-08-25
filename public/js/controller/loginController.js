angular.module('portal').controller("LoginController", function($scope, $http){

    $scope.logar = function(usuario){
        console.log(usuario);

        $http.post("http://172.16.18.120:8080/portal/usuario?login=usuario&senha=usuario").then(
        function(retorno){
            console.log(retorno);
        },
        function(erro){
            console.log("Erro"+ erro); 
        }); 
    }

});
