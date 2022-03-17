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

                    var card = result.data;
                    var packVar = $(
                                    '<tr>'+
                                        '<td hidden="true">' + card.id + '</td>' +
                                        '<td>' + card.name + '</td>' +
                                        '<td>' + card.frontSide + '</td>' +
                                        '<td>' + card.backSide + '</td>' +
                                    '</tr>'
                    );
                    $('#cardsTable').prepend(packVar);
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