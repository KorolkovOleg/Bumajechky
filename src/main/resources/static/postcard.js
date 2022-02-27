$(document).ready(
    function() {
    $('#createCardForm').submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {

        var formData = {
            name: $('#createdCardName').val(),
            frontSide: $('#createdCardFrontSide').val(),
            backSide: $('#createdCardBackSide').val()
        }

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: window.location.href + '/createcard',
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
                console.log('ERROR: ' + e );
            }
        });
    }
});