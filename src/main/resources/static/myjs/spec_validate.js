 $(document).ready(function(){
        //1hide errror section
        $("#specCodeError").hide();
        $("#specNameError").hide();
        $("#specNoteError").hide();

        //2define error variable
        specCodeError=false;
        specNameError=false;
        specNoteError=false;

        //3 validate function
        function validate_code(){
            var val= $("#specCode").val();
            var exp= /^[A-Z\s]{4,50}$/;
            if(val== ''){
                $("#specCodeError").show();
                $("#specCodeError").html("djdhfkshf");
                $("#specCodeError").css('color','red');
                specCodeError=false;
            }else if(!exp.test(val)){
               
                $("#specCodeError").show();
                $("#specCodeError").html("character must be between 4-12 char");
                $("#specCodeError").css('color','red');
                specCodeError=false;
            }else{
                $("#specCodeError").hide();
                specCodeError=true;
            }
            return specCodeError;
        };

        //2
            function validate_name(){
                var val = $("#specName").val();
                var exp= /^[A-Za-z0-9\s\.]{4,25} $/;
                if(val==''){
                    $("#specNameError").show();
                    $("#specNameError").html("*Please enter valid name here");
                    $("#specNameError").css('color','red');
                    specNameError=false;

                }else if(!exp.test(val)){
                    $("#specNameError").show();
                    $("#specNameError").html("*Please enter 4-12 name here");
                    $("#specNameError").css('color','red');
                    specNameError=false;
                
                }else{
                    $("#specNameError").hide();
                    specNameError=true;
                }
                return specNameError;
            }

            //3
            function validate_note(){
                var val=$("#specNote").val();
                var exp=/^[A-Za-z0-9\s\.\-\,]{10,150}$/;
                if(val ==''){
                    $("#specNoteError").show();
                    $("#specNoteError").html("*Please Enter note here");
                    $("#specNoteError").css('color','red');
                    specNoteError=false;
                }else if(!exp.test(val)){
                    $("#specNoteError").show();
                    $("#specNoteError").html("*Please Enter A-Za-z0-9(space) note here");
                    $("#specNoteError").css('color','red');
                    specNoteError=false;
               
                }else{
                    $("#specNoteError").hide();
                    specNoteError=true;
                }


                return specCodeError;
            }


        //4 action event
        $("#specCode").keyup(function(){
            validate_code();
        });
        $("#specName").keyup(function(){
            validate_name();
        });
        $("#specNote").keyup(function(){
            validate_note();
        });
        


        //5 on submit
        $("#specForm").submit(function(){
            //call all validate functions
            validate_code();
            validate_name();
            validate_note();
            if(specCodeError && specNameError && specNoteError)return true;
            else return false;
        });
    });