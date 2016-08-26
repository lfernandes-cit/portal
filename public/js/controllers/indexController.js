angular.module('portal').controller("IndexController", function($scope, $rootScope, $cookies){
    if($cookies.getObject("usuarioLogado")){
        $rootScope.usuarioLogado = $cookies.getObject("usuarioLogado");
    }

    $scope.removeUsuarioCookie = function(){
        $cookies.remove("usuarioLogado");
        $rootScope.usuarioLogado = null;
    }

});
