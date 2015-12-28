package com.familyedu.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.familyedu.model.HomePageAnswerListInfo;
import com.familyedu.model.HomePageIssueListInfo;
import com.familyedu.model.IssueCon;
import com.familyedu.model.MyClassroom;
import com.familyedu.model.MyConsumptionInfo;
import com.familyedu.model.MyTeacher;
import com.familyedu.model.MyTeacherListItemInfo;
import com.familyedu.model.MyTeacherNotificationInfo;
import com.familyedu.model.QuestionInfo;
import com.familyedu.model.StudentCollectInfo;
import com.familyedu.model.StudentLookQuestionInfo;
import com.familyedu.model.TeacherAccount;
import com.familyedu.model.TeacherCollectInfo;
import com.familyedu.model.UserInfo;
import com.familyedu.model.VersionInfo;

public class JsonParse {

	/**
	 * 用户登录
	 */
	public static Object parseUserLogin(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("logBln");
			if (flag == true) {
				Map<String, Object> usertype = (Map<String, Object>) map.get("userOut");
				UserInfo user = new UserInfo();
				user.birthday = (String) usertype.get("birthday");
				user.createTime = (String) usertype.get("createTime");
				user.emailAddress = (String) usertype.get("emailAddress");
				user.emailAddressStatus = (Integer) usertype.get("emailAddressStatus");
				user.headImg = (String) usertype.get("headImg");
				user.nickname = (String) usertype.get("nickname");
				user.password = (String) usertype.get("password");
				user.status = (Integer) usertype.get("status");
				user.username = (String) usertype.get("username");
//				user.usertype = (Integer) usertype.get("usertype");
				user.roleType = (String) usertype.get("roleType");
				ro.result = true;
				ro.obj = user;
			} else {
				ro.result = false;
				ro.obj = map.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}

	/**
	 * 学生注册
	 */
	public static Object parseStudentRegister(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}

	/**
	 * 老师注册
	 */
	public static Object parseTeacherRegister(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 解析学生首页问题列表
	 */
	public static Object parseMainIssueList(String str) {
		ResultObject ro = new ResultObject();
		try {
			ro.result = true;
			ro.obj = new HomePageIssueListInfo().parser(str);
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}
	
	/**
	 * 解析老师首页回答列表
	 */
	public static Object parseMainAnswerList(String str) {
		ResultObject ro = new ResultObject();
		try {
			ro.result = true;
			ro.obj = new HomePageAnswerListInfo().parser(str);
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}

	public static Object parseQuestionListWall(String str) {
		ResultObject ro = new ResultObject();
		try {
			ro.result = true;
			ro.obj = new HomePageIssueListInfo().parser(str);
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}
	
	/**
	 * 教师查看问题
	 */
	public static Object parseTeacherLookQuestionInfo(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject jsonObject = JSONObject.parseObject(str);
			boolean result = jsonObject.getBooleanValue("result");
			if(result) {
				ro.result = true;
				ro.obj = new QuestionInfo().parser(jsonObject);
			} else {
				ro.result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}
	
	/**
	 * 作文提交
	 */
	public static Object parseAddCompositionInfo(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATAREQUEST_FAIL_ERROR);
		}
		return ro;
	}
	
	/**
	 * 提交满意or不满意
	 */
	public static Object parseAttentionType(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("result");
			if (flag == true) {
				ro.result = true;
			} else {
				ro.result = false;
				ro.obj = map.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}

	/**
	 * 更新学生信息
	 */
	public static Object parseUpdateStudent(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 更新老师信息
	 */
	public static Object parseUpdateTeacher(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}

	/**
	 * 老师是否可以认领问题
	 */
	public static Object parseIsQuestionClaim(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 教师放弃问题
	 */
	public static Object parseIsQuestionAccept(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 教师“我的回答”
	 */
	public static Object parseTeacherAnswerList(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 问题提交
	 */
	public static Object parseAddQuesionInfo(String str) {
		ResultObject ro = new ResultObject();
		try {
			Map<String, Object> map = JSON.parseObject(str);
			Boolean flag = (Boolean) map.get("cpsBln");
			ro.result = flag;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的教师-我的收藏
	 */
	public static Object parseMyCollect(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result");
			if(success) {
				ArrayList<TeacherCollectInfo> list = new ArrayList<TeacherCollectInfo>();
				JSONArray sJsonArray = json.getJSONArray("mcollect");
				for (Object object : sJsonArray) {
					list.add(new TeacherCollectInfo().parser((JSONObject) object));
				}
				ro.result = true;
				ro.obj = list;
			} else {
				ro.result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的家教-我的收藏—删除选中
	 */
	public static Object parseDeleteStudentCollect(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			ro.result = success;
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;  
	}
	
	/**
	 * 解答问题
	 */
	public static Object parserTeacherAnswerQuestion(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			ro.result = json.getBooleanValue("cpsBln");
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 学生查看问题内容
	 */
	public static Object parserStudentLookQuestion(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			ro.result = true;
			ro.obj = new StudentLookQuestionInfo().parser(json);
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的家教
	 */
	public static Object parserMyHomeTeacher(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			JSONObject jsonInfo = json.getJSONObject("myinfo");
			ro.result = true;
			ro.obj = new MyTeacher().parser(jsonInfo);
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的家教-我的老师
	 */
	public static Object parserMyTeacherList(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			if(success) {
				JSONArray jsonArray = json.getJSONArray("mteachers");
				ArrayList<MyTeacherListItemInfo> list = new ArrayList<MyTeacherListItemInfo>();
				for (Object object : jsonArray) {
					list.add(new MyTeacherListItemInfo().parser((JSONObject) object));
				}
				ro.result = true;
				ro.obj = list;
			} else {
				ro.result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的家教-我的通知
	 */
	public static Object parserMyTeacherNotification(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			if(success) {
				JSONArray jsonArray = json.getJSONArray("inform");
				ArrayList<MyTeacherNotificationInfo> list = new ArrayList<MyTeacherNotificationInfo>();
				for (Object object : jsonArray) {
					list.add(new MyTeacherNotificationInfo().parser((JSONObject) object));
				}
				ro.result = true;
				ro.obj = list;
			} else {
				ro.result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的教室
	 */
	public static Object parserMyClassroom(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			if(success) {
				ro.result = true;
				ro.obj = new MyClassroom().parser(json.getJSONObject("classroom"));
			} else {
				ro.result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 老师 账户
	 */
	public static Object parserTeacherAccount(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			if(success) {
				ro.result = true;
				ro.obj = new TeacherAccount().parser(json.getJSONObject("account"));
			} else {
				ro.result = false;
				ro.obj = json.getString("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
	
	/**
	 * 我的家教-我的消费
	 */
	public static Object parserMyConsumption(String str) {
		ResultObject ro = new ResultObject();
		try {
			JSONObject json = JSON.parseObject(str);
			boolean success = json.getBooleanValue("result"); 
			if(success) {
				ro.result = true;
				ro.obj = new MyConsumptionInfo().parser(json);
			} else {
				ro.result = false;
				ro.obj = json.getString("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ro.result = false;
			ro.obj = ErrorMessage.getErrorInfo(ErrorMessage.DATA_EXCEPTION_ERROR);
		}
		return ro;
	}
}
