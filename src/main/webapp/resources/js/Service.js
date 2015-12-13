var appService = angular.module('myApp.service', []);

appService.factory('ItemFactory', function($resource){
	return $resource('api/items/:id');
})

appService.service('ItemService', function ($log, ItemFactory) {
    return {
        getAll: function () {    
            return ItemFactory.query(); 
        }
    }
});