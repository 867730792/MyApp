package colorie;
//����ָ�����Զ����ָ࣬�����������������
public class Food {
	private String name;
	private int imageId;
		public Food(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

		public String getName() {
			return name;
		}
		//���Food��ͼƬID��
		public int getImageId() {
		return imageId;
		}
}
