

angular.module('app-chat').controller('CadastroController', function($scope, $http, $filter) {

		$scope.apelido = "";
		$scope.email = "";
		$scope.senha = "";
		
        $scope.cadastrar = function() {
        	var novoUsuario = {
        			apelido: $scope.apelido,
        			email:	$scope.email,
        			senha:	$scope.senha
        	}
        	
        	var baseUrl = "api/chat/cadastro";
        	$http.post(baseUrl, novoUsuario).success(function(data) {
        		$scope.mensagem = data.mensagem;
        		limparCampos();
        	}).error(function(data){
        		//errorCallback(data.error);
        	});
        }
        	
    	$scope.validarApelido = function() {
    		var baseUrl = "api/chat/validar-apelido";
    		$http.post(baseUrl + "/" + $scope.apelido).success(function(data) {
    			$scope.mensagem = data.mensagem;
    		}).error(function(data){
    			//errorCallback(data.error);
    		});	
    	};
    	
    	 function limparCampos(){
         	$scope.apelido = "";
     		$scope.email = "";
     		$scope.senha = "";
         }
});