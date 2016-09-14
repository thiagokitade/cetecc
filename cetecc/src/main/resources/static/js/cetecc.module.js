angular.module('cetecc', [ 'ngRoute', 'auth', 'home', 'navigation' ])

.config([ '$routeProvider','$locationProvider','$httpProvider', function($routeProvider,$locationProvider,$httpProvider) {
		
		$locationProvider.html5Mode({
			enabled: true	
			
		});
	
		 $routeProvider.when('/', {
		      templateUrl : 'js/home/home.html',
		      controller : 'home',
		      controllerAs: 'controller'
		    }).when('/login', {
		      templateUrl : 'js/navigation/login.html',
		      controller : 'navigation',
		      controllerAs: 'controller'
		    }).otherwise('/');
		 
		 $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

	
	} ]).run(function(auth) {

		// Initialize auth module with the home page and login/logout path
		// respectively
		auth.init('/', '/login', '/logout');

	});
	
	
	