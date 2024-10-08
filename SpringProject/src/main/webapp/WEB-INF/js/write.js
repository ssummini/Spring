$(function () {
    console.log('dsa');
    $('#id').on('focusout', function(){
        $('#idDiv').empty(); 
        let id = $('#id').val(); 

        if (id === '') {
            $('#idDiv').html('아이디를 입력하세요.').css('color', 'red'); 
        } else {
            $.ajax({
                type: 'post',
                url: '/spring/user/idCheck', 
                data: {'id': id},
                dataType: 'text',
                success: function(data){	
                	console.log(data);		   
                    if (data == 1) {  // 서버에서 받은 데이터 확인
                        $('#idDiv').html('이미 사용 중인 아이디입니다.').css('color', 'red');
                    } else {
                        $('#idDiv').html('사용가능한 아이디입니다.').css('color', 'green');           
                    }
                },
                error: function(e){
                    console.log(e);
                }
            });
        }
    });
});
