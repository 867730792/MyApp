package colorie;
//泛型指定的自定义类，指定了两个所需参数。
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
		//获得Food的图片ID。
		public int getImageId() {
		return imageId;
		}
}
