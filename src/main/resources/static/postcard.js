$(document).ready(
    function() {
    $('#createCardForm').submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
//        var token = $("meta[name='_csrf']").attr("content");
//        var header = $("meta[name='_csrf_header']").attr("content");
//        $(document).ajaxSend(function(e, xhr, options) {
//        xhr.setRequestHeader(header, token);
//        });

        var formData = {
            name: $('#createdCardName').val(),
            frontSide: $('#createdCardFrontSide').val(),
            backSide: $('#createdCardBackSide').val()
        }

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/pack/10/createcard',
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(result) {
                if(result.status == 'success') {
                    $('#postResultDiv').html(
                        '' + result.data.name + ' Post successfully'
                    );
                } else {
                $('#postResultDiv').html(
                                        'Post не successfully'
                                    );
                }
                console.log(result);
            },
            error: function(e) {
                alert('error');
                console.log('ERROR: ' + e );
            }
        });
    }
});