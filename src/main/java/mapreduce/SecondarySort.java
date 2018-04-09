package mapreduce;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
//MAC TIME键值对做key
public class SecondarySort {
	
	public static class MACTimePair implements WritableComparable<MACTimePair> {
		private String MAC;
		private String time;
		
		public String getMAC() {
			return MAC;
		}

		public String getTime() {
			return time;
		}
		
		public void set(String mac,String time){
			this.MAC = mac;
			this.time = time;
		}

		public void write(DataOutput out) throws IOException {
			out.writeUTF(MAC);
			out.writeUTF(time);
			
		}

		public void readFields(DataInput in) throws IOException {
			this.MAC = in.readUTF();
			this.time = in.readUTF();
			
		}
		
		@Override
		public int hashCode(){
			return this.MAC.hashCode()*127 + this.time.hashCode();
		}
		
		@Override
		public boolean equals(Object right){
			if(right instanceof MACTimePair){
				MACTimePair r = (MACTimePair) right;
				return r.MAC == MAC && r.time == time;
			}else{
				return false;
			}
		}

		public int compareTo(MACTimePair o) {
			if(!MAC.equals(o.MAC)){
				return MAC.compareTo(o.MAC);
			}
			else if(!time.equals(o.time)){
				return time.compareTo(o.time);
			}
			else {
				return 0;
			}
		}
		
		public String toString(){
			return MAC + "\t" + time;
		}

	}
	
}
