

angular.module('app-chat').controller('LoginController', function($scope, $http, $filter) {

        $scope.login = function() {
        	var baseUrl = "api/chat/login";
        	$http.get(baseUrl).success(function(data) {
    		alert(data.mensagem);
    	});
    	
    };
    
});