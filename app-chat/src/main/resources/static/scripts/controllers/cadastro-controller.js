

angular.module('app-chat').controller('CadastroController', function($scope, $http, $state) {

		$scope.apelido = "";
		$scope.email = "";
		$scope.senha = "";
		
		init();
		
		function init(){			
			var baseUrl = "api/chat/cadastro";
			$http.get(baseUrl).success(function(data) {
			});
		}
		
        $scope.cadastrar = function() {
        	var novoUsuario = {
    			apelido: $scope.apelido,
    			email:	$scope.email,
    			senha:	$scope.senha
        	}
        	
        	var baseUrl = "api/chat/cadastro";
        	$http.post(baseUrl, novoUsuario).success(function(data) {
        		$scope.mensagemSucesso = data.mensagemSucesso;
        		limparCampos();
        	}).error(function(data){
        		
        	});
        }
        	
    	$scope.validarApelido = function() {
    		var baseUrl = "api/chat/validar-apelido";
    		$http.post(baseUrl + "/" + $scope.apelido).success(function(data) {
    			$scope.mensagemSucesso = null;
    			$scope.mensagemErro = data.mensagemErro;
    		}).error(function(data){

    		});	
    	};
    	
    	 function limparCampos(){
         	$scope.apelido = "";
     		$scope.email = "";
     		$scope.senha = "";
         }
    	 
    	 $scope.voltar = function(){
    		 $state.go('login');
    	 }
});