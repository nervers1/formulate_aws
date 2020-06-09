package kr.or.formulate.proceed;

import kr.or.formulate.model.Person;
import kr.or.formulate.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class InstanceTest {
    public static void main(String[] args) {

        Person a = new Person("김태윤", 22);
        Student s1 = new Student("김병기", 44, "1학년", "한양대학교");
        Student s2 = new Student("박효훈", 43, "2학년", "명지대학교");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("김서방", new Student("김병기", 44, "2학년", "한양대학교"));
        map.put("박서방", new Student("박효훈", 43, "1학년", "명지대학교"));
        map.put("오서방", new Student("오형일", 54, "12학년", "고려대학교"));
        map.put("조서방", new Student("조성학", 40, "2학년", "서강대학교"));
        map.put("김태윤", new Person("김태윤", 44));
        map.put("홍길동", new Person("홍길동", 460));
        list.add(map);

        List<String> innerList = new ArrayList<>(Arrays.asList("John", "Tom", "Cathy"));


        Map<String, Object> map2 = new HashMap<>();
        map2.put("가가가", 12);
        map2.put("나나나", 14);
        map2.put("다다다", 13);
        map2.put("라라라", 22);
        map2.put("Dummy", innerList);
        list.add(map2);

        log.info("-----------------------------------------------------");
        log.info("List : {}", list);
        log.info("-----------------------------------------------------");

        int cnt = list.size();
        log.info("list Size : {}", cnt);
        Map<String, Object> temp = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            Map<String, Object> item = list.get(i);
            for (String key : item.keySet()) {
                Object obj = item.get(key);
                log.info("key : {}, value : {},  ... class : {}", key, obj, obj.getClass());
                if (obj instanceof Map<?,?>) {
                    Map<String, Object> tmpMap = (HashMap<String, Object>) obj;
                    log.info("HashMap check : {}", tmpMap);
                    for (String mKey : tmpMap.keySet()) {
                        temp.put(key, tmpMap.get(mKey));
                    }
                } else if (obj instanceof List) {
                    log.info("List check : {}", obj);
                    Iterator iterator = ((List) obj).iterator();
                    while(iterator.hasNext()) { temp.put(iterator.next().toString(), 10);}
                } else if (obj instanceof Student) {
                    log.info("<Student> of name : {}, age : {}, school : {}, grade : {}", ((Student) obj).getName(), ((Student) obj).getAge(), ((Student) obj).getSchoolName(), ((Student) obj).getGrade());
                    temp.put(((Student)obj).getName(), ((Student)obj).getAge());
                } else if (obj instanceof Person) {
                    log.info("<Person> of name : {}, age : {}", ((Person) obj).getName(), ((Person) obj).getAge());
                    temp.put(((Person)obj).getName(), ((Person)obj).getAge());
                }
                log.info("temp --> {}", temp);
            }


        }

    }

}