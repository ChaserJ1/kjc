function formatDate(timeStamp)
{
	console.log(typeof timeStamp)
	var type = typeof timeStamp
	if (type != "string"){
		var time = new Date(timeStamp.time);
		var y = time.getFullYear();
		var m = time.getMonth()+1;
		var da = time.getDate();
		var h = time.getHours();
		var mm = time.getMinutes();
		var s = time.getSeconds();
		s = s < 10 ? '0' + s: s;
		var addtime = y+"-"+m+"-"+da+" "+h+":"+mm+":"+s;
		return addtime;
	} else {
		return timeStamp
	}	
}