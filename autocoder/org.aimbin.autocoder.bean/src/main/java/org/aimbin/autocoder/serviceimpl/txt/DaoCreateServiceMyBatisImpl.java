/** fun_endless@163.com  2018年12月14日 */
package org.aimbin.autocoder.serviceimpl.txt;

import java.util.List;
import java.util.Map;

import org.aimbin.autocoder.coders.TypeNames;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.component.ClassMethod;
import org.aimbin.autocoder.component.ClassedUtils;
import org.aimbin.autocoder.component.LoadedTypeClassed;
import org.aimbin.autocoder.confconst.JavaCodeUtils;
import org.aimbin.autocoder.confconst.JavaCodes;
import org.aimbin.autocoder.service.DaoCreateService;
import org.aimbin.commons.javas.StrOps;

/**Create MyBatis mapper from {@link ClassContent}. Created method include : 
 * <ul>
 * <li>public void createBean(Bean bean);</li>
 * <li>public void updateBean(Bean bean);</li>
 * <li>public void deleteBean(String id);</li>
 * <li></li>
 * <li></li>
 * </ul>
 * @author aimbin
 * @verison 1.0.0 2018年12月14日
 */
public class DaoCreateServiceMyBatisImpl implements DaoCreateService {
	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.service.DaoCreateService#createDao(java.lang.Object, java.util.Map)
	 */
	@Override
	public ClassContent createDao(Object beanClaz, Map<String, String> configs) {
		ClassContent bean = (ClassContent) beanClaz;
		String pkg = JavaCodeUtils.replaceEnd(bean.getPackg(), JavaCodes.PKG_BEAN, JavaCodes.PKG_DAO) ;
		String shortName = bean.getSimpleName() + "Mapper";
		String fullName = pkg + shortName;
		ClassContent mapperContent = new ClassContent(fullName, shortName);
		mapperContent.setTypeName(TypeNames.INTERFACE);
		mapperContent.setPackg(pkg);
		//public void createBean(Bean bean);
		ClassMethod c = new ClassMethod("create" + bean.getSimpleName());
		c.addParameter(StrOps.lowerFirst(bean.getSimpleName()), bean);
		mapperContent.addMethod(c);
		// public void updateBean(Bean bean);
		ClassMethod u = new ClassMethod("update" + bean.getSimpleName());
		u.addParameter(StrOps.lowerFirst(bean.getSimpleName()), bean);
		mapperContent.addMethod(u);
		// public void deleteBean(String id);
		ClassMethod d = new ClassMethod("delete" + bean.getSimpleName());
		d.addParameter("id", new LoadedTypeClassed(String.class));
		mapperContent.addMethod(d);
		JavaCodeUtils.distToFile(mapperContent, configs, true);
		// public void deleteBean(String id);
		ClassMethod q = new ClassMethod("query" + bean.getSimpleName());
		q.setJavaType(ClassedUtils.toClassed(List.class,bean));
		q.addParameter("filter", ClassedUtils.toClassed(Map.class,String.class,Object.class));
		mapperContent.addMethod(q);
		JavaCodeUtils.distToFile(mapperContent, configs, true);
		return mapperContent;
	}

}
