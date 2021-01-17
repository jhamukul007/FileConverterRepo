function convertTextToPDF(){
	var formData=new FormData();
	if(!$('#upload_file')[0].files[0]){
		alert("Please, Select File");
		return;
	}
	var data=$('#upload_file')[0].files[0];
	var convertFrom=fileConvertedForm(fileExtension(data.name));
	formData.append('file',data);
	var convertTo=$('input[name="convert_to"]:checked').val();
	
	var params={
		form: formData,
		convertFrom:convertFrom,
		convertTo:convertTo
	}
	formData.append('params',params);
	$.ajax({
		type:"POST",
		url:"http://localhost:8082/v1/pdf/convert/text",
		param: formData,
		contentType: "multipart/form-data",
		success: function(resp){
			alert(resp);
		},
		error: function(resp){
			alert(resp);
		}
	
	});
}