package demo;

import java.util.Arrays;

public class CreateBinaryTree {
	public TreeNode createBinaryTree(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		CreateBinaryTree createBinaryTree = new CreateBinaryTree();
		createBinaryTree.createBinaryTree(nums);

	}

}

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
	}
}
