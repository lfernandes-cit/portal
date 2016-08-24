angular.module('portal').controller("LoginController", function($scope, $http){

    $scope.logar = function(usuario){
        console.log(usuario);
        $http.post("http://172.16.15.204:8080/portal/usuario", usuario).then(
        function(retorno){
            console.log(retorno);
        },
        function(erro){
            console.log(erro);        
        }); 
    }

});
