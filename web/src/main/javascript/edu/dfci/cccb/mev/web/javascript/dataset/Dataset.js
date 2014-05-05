define(['angular',
        './lib/DatasetClass', 
        './lib/generateView',
        './lib/generateRowFilteredView', 
        './lib/loadAnalyses',
        'api/Api'], 
function(angular, DatasetClass, generateView, generateRowFilteredView, loadAnalyses){
	
	return angular.module('Mev.Dataset', ['Mev.Api'])
	.factory('DatasetFactory', ['AnalysisResourceService', 'SelectionResourceService',
	 function(AnalysisResourceService, SelectionResourceService){
		return function(id, initialData){
				var dataset = new DatasetClass(id, initialData);				
		
				dataset.analysis = AnalysisResourceService;
				dataset.selection = SelectionResourceService;

				dataset.generateView = generateView;
				dataset.generateRowFilteredView = generateRowFilteredView;
				dataset.loadAnalyses = loadAnalyses;
				
				return dataset;
				
			};
	}]);
});