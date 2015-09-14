define(["ng", "lodash"], function(ng, _){
	var module = ng.module("mui.views.dataset.analysis.topgo", []);
	module.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider){}])
	.controller("TopGoVM", ["$scope", "$state", "$stateParams", "tableResultsFilter", "project", "analysis",
	                        function($scope, $state, $stateParams, tableFilter, project, analysis){
		
		this.analysisId=$stateParams.analysisId;
		this.analysis=analysis;
		this.project=project;
		$scope.dataset=project.dataset;
		$scope.analysis = analysis;
		
		$scope.headers = [
            {
                'name': 'ID',
                'field': "goId",
                'icon': "search"
            },
            {
                'name': 'GO Term',
                'field': "goTerm",
                'icon': "search"
            },
            {
                'name': 'Annotated Genes',
                'field': "annotatedGenes",
                'icon': [">=", "<="]
            },
            {
                'name': 'Significant Genes',
                'field': "significantGenes",
                'icon': [">=", "<="]
            },
            {
                'name': 'Expected',
                'field': "expected",
                'icon': [">=", "<="]
            },
            {
                'name': 'P-Value',
                'field': "pValue",
                'icon': "<=",
                'default': 0.05
            },
            {
                'name': 'Adj. P-Value',
                'field': "pValue",
                'icon': "<="
            }
            
        ];
        
        $scope.filteredResults = undefined;
        $scope.viewGenes = function (filterParams) {
	    	
	        $scope.filteredResults = tableFilter($scope.analysis.results, filterParams);                                
	        console.debug("topgo ", $scope.filteredResults);
	    };
	}]);
	return module;
});