'use strict';

angular.module('app-chat', [ 'ngRoute', 'ngResource' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : '/login.html',
				controller : 'LoginController'
			}).when('/cadastro', {
				templateUrl : '/cadastro.html',
				controller : 'CadastroController'
			}).otherwise({
				redirectTo : '/'
			});
		} ]).controller('LandingPageController',
		function LandingPageController() {
		}).controller(
		'NavController',
		function NavController($scope, $location) {
			$scope.matchesRoute = function(route) {
				var path = $location.path();
				return (path === ("/" + route) || path.indexOf("/" + route
						+ "/") == 0);
			};
		});
