'use strict';

angular.module('app-chat',['ui.router','ngResource']);

angular.module('app-chat').config(function($stateProvider){
    $stateProvider.state('login',{
        url:'/login',
        templateUrl:'/login.html',
        controller:'LoginController'
    }).state('chat',{
       url:'/chat',
       templateUrl:'/chat.html',
       controller:'ChatController'
    }).state('cadastro',{
        url:'/cadastro',
        templateUrl:'/cadastro.html',
        controller:'CadastroController'
     });
}).run(function($state){
   $state.go('login');
});