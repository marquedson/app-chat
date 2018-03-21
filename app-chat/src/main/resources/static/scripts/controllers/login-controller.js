
angular.module('app-chat').controller('LoginController', function($scope, $http, $state) {

		$scope.email = "";
		$scope.senha = "";
		
        $scope.login = function() {
        	
        	var loginUsuario = {
    			email:	$scope.email,
    			senha:	$scope.senha
        	}
        	
        	var baseUrl = "api/chat/login";
        	
        	$http.post(baseUrl, loginUsuario).success(function(data) {
        		if(data.mensagemSucesso) {
        			$scope.mensagemErro = null;
        			$scope.mensagemSucesso = data.mensagemSucesso;
        		}else{      
        			$scope.mensagemSucesso = null;
        			$scope.mensagemErro = data.mensagemErro;
        		}
        	}).error(function(data){
        		$scope.mensagem = data.mensagemErro;
        	});
        }
        
        $scope.cadastroRedirect = function () {
        	$state.go('cadastro');
        }
    
});