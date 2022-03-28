$(document).ready(function () {

    let conf = $('#conference');

    let id = conf.find('option:selected').attr('value')

    $("input[type='hidden']").val(id);

    conf.change(function () {
        $("input[type='hidden']").val($('#conference').find('option:selected').attr('value'));
    });

    $('.timepicker').timepicker({
        timeFormat: 'HH:mm',
        interval: 60,
        minTime: '09',
        maxTime: '9:00pm',
        defaultTime: '09',
        startTime: '09:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });

});