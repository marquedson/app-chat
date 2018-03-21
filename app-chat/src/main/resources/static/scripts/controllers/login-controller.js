

angular.module('app-chat').controller('LoginController', function($scope, $http, $filter) {

		$scope.email = "";
		$scope.senha = "";
		
        $scope.login = function() {
        	
        	var loginUsuario = {
    			email:	$scope.email,
    			senha:	$scope.senha
        	}
        	
        	var baseUrl = "api/chat/login";
        	
        	$http.post(baseUrl, loginUsuario).success(function(data) {
        		$scope.mensagem = data.mensagem;
        	}).error(function(data){
        		$scope.mensagem = data.mensagem;
        	});
        }
    
});