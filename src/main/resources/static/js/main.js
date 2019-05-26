const professionArr = ['', '计算机控制', '网络安全', '计算机应用'];
const sexArr = ['男', '女'];

const confirm_delete = id => {
  // resume_remove.php?id=
  // alert( id );
  if (confirm("确定要删除么？")) {
    $.ajax({
      url: 'delete_by_id.do?id=' + id,
      type: 'DELETE',
      success: () => window.location.reload()
    });
  }
};

const send_form = form => {
  $.post($(form).attr("action"), $(form).serialize(), data => {
    const notice = $("#form_notice");
    if (data.code === 1) {
      notice ? notice.html('成功') : '';
      window.location.replace('index.html');
    } else if (notice) {
      notice.html(data.result);
    }
  });
};

const getQueryStringParameters = () => {
  let url = window.location.href;
  let query = window.location.search.substring(1);
  return (/^[?#]/.test(query) ? query.slice(1) : query)
  .split('&')
  .reduce((params, param) => {
    let [key, value] = param.split('=');
    params[key] = value ? decodeURIComponent(value.replace(/\+/g, ' '))
        : '';
    return params;
  }, {});
};

const parseAge = identityCard => {
  const len = (identityCard + "").length;
  let strBirthday = "";
  //处理18位的身份证号码从号码中得到生日和性别代码
  if (len === 18) {
    strBirthday = identityCard.substr(6, 4) + "/" + identityCard.substr(10,
        2) + "/" + identityCard.substr(12, 2);
  }
  if (len === 15) {
    let birthdayValue;
    birthdayValue = identityCard.charAt(6) + identityCard.charAt(7);
    if (parseInt(birthdayValue) < 10) {
      strBirthday = "20" + identityCard.substr(6, 2) + "/"
          + identityCard.substr(8, 2) + "/" + identityCard.substr(10, 2);
    } else {
      strBirthday = "19" + identityCard.substr(6, 2) + "/"
          + identityCard.substr(8, 2) + "/" + identityCard.substr(10, 2);
    }

  }
  //时间字符串里，必须是“/”
  const birthDate = new Date(strBirthday);
  const nowDateTime = new Date();
  let age = nowDateTime.getFullYear() - birthDate.getFullYear();
  //再考虑月、天的因素;.getMonth()获取的是从0开始的，这里进行比较，不需要加1
  if (nowDateTime.getMonth() < birthDate.getMonth() || (nowDateTime.getMonth()
      === birthDate.getMonth() && nowDateTime.getDate()
      < birthDate.getDate())) {
    age--;
  }
  return age;
};