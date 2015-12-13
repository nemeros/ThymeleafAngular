var appController = angular.module('myApp.controller', []);


appController.controller('ItemsController', function($scope, $log, ItemService){
	$scope.items = ItemService.getAll();
});