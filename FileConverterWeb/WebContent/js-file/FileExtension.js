
function fileExtension(fileName){
	if(!fileName){
		return;
	}
	return fileName.split('.').pop();
}

function fileConvertedForm(extension){
	if(!extension){
		return;
	}
	if(extension==='pdf'){
		return "PDF";
	}
	else if(extension=== 'txt'){
		return "TEXT";
	}
}