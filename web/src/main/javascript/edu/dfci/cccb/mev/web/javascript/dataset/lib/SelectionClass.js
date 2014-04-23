define(['extend'], function(extend){
	
	//Constructor :: Object -> $Function
	return function(initialData){
		return function(){
			var self = this;
			
			extend(self, initialData);
		}
	}
})