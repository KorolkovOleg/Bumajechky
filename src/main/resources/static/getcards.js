$(document).ready(
    function() {
    $('#refreshCards').click(function(event) {
        event.preventDefault();
        ajaxGet();
    });

    function ajaxGet() {

        $.ajax({
            type: 'GET',
            url: window.location.href + '/cards',
            success: function(result) {
                if(result.status == 'success') {
                    $('#cardsTable').empty()
                    $.each(result.data, function(i, card) {
                        var packVar = $(
                                        '<tr>'+
                                            '<td hidden="true">' + card.id + '</td>' +
                                            '<td>' + card.name + '</td>' +
                                            '<td>' + card.frontSide + '</td>' +
                                            '<td>' + card.backSide + '</td>' +
                                        '</tr>');
                        $('#cardsTable').append(packVar);
                    });
                } else {
                $('#cardsTable').html(
                                        'Get не successfully'
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