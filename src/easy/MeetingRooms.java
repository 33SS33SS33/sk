package easy;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 */
/*一个人能不能参加所有会议*/
    /**会议中间时间没有重叠的话就可以参加*/
public class MeetingRooms {
    public static void main(String[] args) {
        Interval inter1=new Interval(1,4);
        Interval inter2=new Interval(5,6);
        Interval[] intervals = {inter1,inter2};
        System.out.println(new MeetingRooms().canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        //Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int maxend = 0;
        for (Interval i : intervals) {
            if (i.start < maxend) {
                return false;
            }
            maxend = Math.max(maxend, i.end);
        }
        return true;
    }

    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
